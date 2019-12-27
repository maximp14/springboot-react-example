package com.maxi.reactspringboot.bucket;

public enum BucketName {

    PROFILE_IMAGE("maxi-image-upload");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }

}
