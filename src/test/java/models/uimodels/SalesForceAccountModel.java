package models.uimodels;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class SalesForceAccountModel {

    private String accountName;
    private String phone;
    private String type;
}
