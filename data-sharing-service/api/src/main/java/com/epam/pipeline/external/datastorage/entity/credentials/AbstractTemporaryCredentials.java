/*
 * Copyright 2017-2019 EPAM Systems, Inc. (https://www.epam.com/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.pipeline.external.datastorage.entity.credentials;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonDeserialize(as = S3TemporaryCredentials.class)
public abstract class AbstractTemporaryCredentials {

    @JsonProperty(value = "accessKey")
    public String accessKey;

    @JsonProperty(value = "keyID")
    public String keyId;

    @JsonProperty(value = "token")
    public String token;

    @JsonProperty(value = "expiration")
    public String expirationTime;

    public String region;

    @JsonIgnore
    public String role;

    @JsonIgnore
    public int duration;

    @JsonIgnore
    public String kmsArn;

    public abstract AbstractTemporaryCredentials generate(List<DataStorageAction> actions);

    public AbstractTemporaryCredentials withRole(String role) {
        this.setRole(role);
        return this;
    }

    public AbstractTemporaryCredentials withDurationSeconds(int duration) {
        this.setDuration(duration);
        return this;
    }

    public AbstractTemporaryCredentials withKmsArn(String kmsArn) {
        this.setKmsArn(kmsArn);
        return this;
    }

}
