package com.faergestad.FirestoreTemplate.service;

import com.faergestad.FirestoreTemplate.annotation.Encrypted;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestObject {

    @Encrypted
    private String sensitiveInfo;
    private String otherInfo;

}
