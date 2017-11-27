package com.dh.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class RestApiController {
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    TextService textService;

    @RequestMapping(value = "/rpc/message/reverse", method = RequestMethod.POST)
    public ResponseEntity<?> reverseText(@RequestBody Message msg) {
        logger.info("Calling custom text reverse for: {}", msg);

        Message reverted = new Message();
        reverted.setText(textService.customReverse(msg.getText()));

        logger.info("Reverted text: {}", msg);
        return new ResponseEntity<Message>(reverted, HttpStatus.OK);
    }
}
