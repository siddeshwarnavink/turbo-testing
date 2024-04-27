package sidd33.turbotesting;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ProductDto.builder()
                .productCode(rs.getString("productCode"))
                .productName(rs.getString("productName"))
                .productLine(rs.getString("productLine"))
                .productScale(rs.getString("productScale"))
                .productVendor(rs.getString("productVendor"))
                .productDescription(rs.getString("productDescription"))
                .quantityInStock(rs.getInt("quantityInStock"))
                .buyPrice(rs.getBigDecimal("buyPrice"))
                .msrp(rs.getBigDecimal("msrp"))
                .build();
    }

}
