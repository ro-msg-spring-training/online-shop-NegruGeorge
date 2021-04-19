package com.example.shop.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class OrderrObjDTO {
    private LocalDate time;
    private AddressDTO addressDTO;
    private List<OrderDetailDTO> orderDetailDTO_List;

}
