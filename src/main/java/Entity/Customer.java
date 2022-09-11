package Entity;
import java.time.LocalDate;
import java.util.Objects;

public class Customer {
     private Integer custId;
     private String userName;
     private String custPassword;
     private String email;
     private String custName;
     private String custSurname;
     private LocalDate custBirth;
     private Integer custMoney;
     private String adress;
     private City cityIdFk;

    public Customer(Integer custId, String userName, String email, String custPassword, String custName, String custSurname, LocalDate custBirth, Integer custMoney, String adress, City cityIdFk) {
        this.custId = custId;
        this.userName = userName;
        this.custPassword = custPassword;
        this.email = email;
        this.custName = custName;
        this.custSurname = custSurname;
        this.custBirth = custBirth;
        this.custMoney = custMoney;
        this.adress = adress;
        this.cityIdFk = cityIdFk;
    }

    public Customer(int custId, String creative, String email, String salam123, String huseyn, String memmedov, LocalDate localDateTime1, double custMoney, String goycay, Integer city) {
    }

    public Integer getCustId() {
        return custId;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSurname() {
        return custSurname;
    }

    public void setCustSurname(String custSurname) {
        this.custSurname = custSurname;
    }

    public LocalDate getCustBirth() {
        return custBirth;
    }

    public void setCustBirth(LocalDate custBirth) {
        this.custBirth = custBirth;
    }

    public Integer getCustMoney() {
        return custMoney;
    }

    public void setCustMoney(Integer custMoney) {
        this.custMoney = custMoney;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public City getCityIdFk() {
        return cityIdFk;
    }

    public void setCityIdFk(City cityIdFk) {
        this.cityIdFk = cityIdFk;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", userName='" + userName + '\'' +
                ", custPassword='" + custPassword + '\'' +
                ", email='" + email + '\'' +
                ", custName='" + custName + '\'' +
                ", custSurname='" + custSurname + '\'' +
                ", custBirth=" + custBirth +
                ", custMoney=" + custMoney +
                ", adress='" + adress + '\'' +
                ", cityIdFk=" + cityIdFk +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getCustId(), customer.getCustId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustId());
    }
}
