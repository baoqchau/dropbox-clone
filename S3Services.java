package com.amazonaws.samples;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;


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
    
    public void displayTextInputStream(InputStream input) throws IOException {
        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println();
    }
    
    //Instead of reading the entire object, you can read only a portion of the object data by specifying the byte range that you want in the request. 
    
    public void GetObject() throws IOException{ 
            String clientRegion = "us-west-2";
            String bucketName = "dropbox-clone-cs4650";
            String key = "*** Object key ***";
            //Object key is a file name
            
            S3Object fullObject = null, objectPortion = null, headerOverrideObject = null;
            try {
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withRegion(clientRegion)
                        .withCredentials(new ProfileCredentialsProvider())
                        .build();

                // Get an object and print its contents.
                System.out.println("Downloading an object");
                fullObject = s3Client.getObject(new GetObjectRequest(bucketName, key));
                System.out.println("Content-Type: " + fullObject.getObjectMetadata().getContentType());
                System.out.println("Content: ");
                displayTextInputStream(fullObject.getObjectContent());
                
                // Get a range of bytes from an object and print the bytes.
                GetObjectRequest rangeObjectRequest = new GetObjectRequest(bucketName, key)
                                                            .withRange(0,9);
                objectPortion = s3Client.getObject(rangeObjectRequest);
                System.out.println("Printing bytes retrieved.");
                displayTextInputStream(objectPortion.getObjectContent());
                
                // Get an entire object, overriding the specified response headers, and print the object's content.
                ResponseHeaderOverrides headerOverrides = new ResponseHeaderOverrides()
                                                                .withCacheControl("No-cache")
                                                                .withContentDisposition("attachment; filename=example.txt");
                GetObjectRequest getObjectRequestHeaderOverride = new GetObjectRequest(bucketName, key)
                                                                .withResponseHeaders(headerOverrides);
                headerOverrideObject = s3Client.getObject(getObjectRequestHeaderOverride);
                displayTextInputStream(headerOverrideObject.getObjectContent());
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
            finally {
                // To ensure that the network connection doesn't remain open, close any open input streams.
                if(fullObject != null) {
                    fullObject.close();
                }
                if(objectPortion != null) {
                    objectPortion.close();
                }
                if(headerOverrideObject != null) {
                    headerOverrideObject.close();
                }
            }
    }
    }
            
        
    
    