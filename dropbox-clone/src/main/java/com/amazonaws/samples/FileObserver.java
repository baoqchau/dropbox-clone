
package com.amazonaws.samples;

import java.io.File;
import java.io.IOException;
import java.util.Observer;
import java.util.Observable;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class FileObserver implements Observer {
	public void update(Observable obj, Object arg)
}