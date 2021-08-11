/**
 * Purpose : To provide response to the end user with a proper message
 *            and also provide the desired results what the end user
 *            has asked for
 */
package com.bridgelabz.krunal.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private String message;
    private Object data;

}
