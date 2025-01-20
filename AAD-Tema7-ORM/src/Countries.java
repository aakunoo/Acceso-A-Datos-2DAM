

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.*;
import java.math.BigInteger;
 
@Entity
@Table(name = "countries") // Nombre de la tabla en la base de datos
public class Countries implements java.io.Serializable {
 
    @Id
    @Column(name = "country_id", nullable = false, length = 2)
    private String countryId;
 
    @Column(name = "country_name", nullable = false, length = 40)
    private String countryName;
 
    @Column(name = "region_id")
    private BigInteger regionId;
 
    // Constructores, getters y setters
 
    public Countries() {
    }
 
    public Countries(String countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }
 
    public Countries(String countryId, String countryName, BigInteger regionId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    }
 
    public String getCountryId() {
        return countryId;
    }
 
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
 
    public String getCountryName() {
        return countryName;
    }
 
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
 
    public BigInteger getRegionId() {
        return regionId;
    }
 
    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }
}