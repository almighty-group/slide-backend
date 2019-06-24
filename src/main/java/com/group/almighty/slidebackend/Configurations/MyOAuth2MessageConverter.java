package com.group.almighty.slidebackend.Configurations;

import com.group.almighty.slidebackend.Dto.ResponseDTO;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import java.io.IOException;

public class MyOAuth2MessageConverter extends MappingJackson2HttpMessageConverter {

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        super.writeInternal(transformObject(object), outputMessage);
    }

    protected Object transformObject(Object object) {
        //ApiResponse is just my own class, replace it with anything you wanna return
        ResponseDTO response = new ResponseDTO();
        response.setResponseCode("0x");
        response.setResponseMessage("XXXXXXXXXXXXX");
        if(object instanceof OAuth2Exception) {
            //....custom code for OAuth2Exception
        }
        return response;
    }
}
