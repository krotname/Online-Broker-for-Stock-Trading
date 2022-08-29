package name.krot.broker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DtoBond {
    private String bondName;
    private long bondCount;
    private long bondTotalPrice;
}
