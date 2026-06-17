package com.utp.hotelmanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {

    private Long id;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
