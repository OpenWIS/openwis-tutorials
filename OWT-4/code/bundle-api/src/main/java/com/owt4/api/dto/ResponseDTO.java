package com.owt4.api.dto;

 /**
 * ResponseDTO
 * 
 */
public class ResponseDTO {

    private String response;
    
        public ResponseDTO(String response) {
            this.response = response;
        }
    
        public String getResponse() {
            return response;
        }
    
        public void setResponse(String response) {
            this.response = response;
        }
    }

