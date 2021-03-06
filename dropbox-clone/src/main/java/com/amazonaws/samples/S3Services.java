package com.amazonaws.samples;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.transfer.*;

public class S3Services {
	
	private static ProfileCredentialsProvider credentialsProvider = null;
	private AmazonS3 s3Client;
	private TransferManager transferManager;
	private String bucketName = "";
	
	public S3Services(String clientRegion, String bucketName) {
		credentialsProvider = new ProfileCredentialsProvider();
		try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/home/bao/.aws/credentials), and is in valid format.",
                    e);
        }
		this.bucketName = bucketName;
		try {
	      this.s3Client = AmazonS3ClientBuilder.standard()
	        .withRegion(clientRegion)
	        .withCredentials(this.credentialsProvider)
	        .build();
	      this.transferManager = TransferManagerBuilder.standard().withS3Client(this.s3Client).build();
		 } catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
         } catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
         }
	}

	public void delete(String fileName) throws IOException {
		try {
			s3Client.deleteObject(new DeleteObjectRequest(this.bucketName, fileName));
		}
	    catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
	}
    public void upload(File file, String fileName) throws IOException {
        try {           
            // Upload a file as a new object with ContentType and title specified.
            PutObjectRequest request = new PutObjectRequest(this.bucketName, fileName, file);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("plain/text");
            metadata.addUserMetadata("x-amz-meta-title", "someTitle");
            request.setMetadata(metadata);
            this.s3Client.putObject(request);
            System.out.println("successfully upload");
        }
        catch(AmazonServiceException e) {
            // The call was transmitted successfully, but Amazon S3 couldn't process 
            // it, so it returned an error response.
            e.printStackTrace();
        }
        catch(SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> getDirectoriesInBucket() throws IOException {
      ArrayList<String> directories = new ArrayList<>();
    	try {
	        ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(this.bucketName);
	        ListObjectsV2Result result;
	        do {
	            result = s3Client.listObjectsV2(req);
	
	            for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
	              StringBuilder objectKey = new StringBuilder(objectSummary.getKey());
	              String directory = objectKey.substring(0, objectKey.indexOf("/"));
	              if (!directories.contains(directory)) {
	                directories.add(directory);
	              }
	            }
	            // If there are more than maxKeys keys in the bucket, get a continuation token
	            // and list the next objects
	        } while (result.isTruncated());
	    }
	    catch(AmazonServiceException e) {
	        // The call was transmitted successfully, but Amazon S3 couldn't process 
	        // it, so it returned an error response.
	        e.printStackTrace();
	    }
	    catch(SdkClientException e) {
	        // Amazon S3 couldn't be contacted for a response, or the client
	        // couldn't parse the response from Amazon S3.
	        e.printStackTrace();
	    }
    	return directories;
    }
    
    public void downloadFileFromDirectory(String dirToDownload, String storedDir) throws IOException {
      try {
    	transferManager.downloadDirectory(this.bucketName, dirToDownload, new File(storedDir));
      } catch(AmazonServiceException e) {
    	  e.printStackTrace();
      } catch (SdkClientException e) {
    	  e.printStackTrace();
      }
    }
}