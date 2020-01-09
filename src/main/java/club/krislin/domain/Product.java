package club.krislin.domain;

import club.krislin.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Package club.krislin.domain
 * @ClassName Product
 * @Description 产品
 * @Date 20/1/5 16:22
 * @Author LIM
 * @Version V1.0
 */
public class Product {
    /**
     * 主键
     */
    private int id;
    /**
     * 编号 唯一
     */
    private String productNum;
    /**
     * 名称
     */
    private String productName;
    /**
     * 出发城市
     */
    private String cityName;
    /**
     * 出发时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;
    /**
     * 产品价格
     */
    private double productPrice;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 状态 0 关闭 1 开启
     */
    private Integer productStatus;
    private String productStatusStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime!=null){
            departureTimeStr = DateUtils.date2String(departureTime,"yyyy-MM-dd HH:mm");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus!=null){
            if (productStatus==0){
                productStatusStr="关闭";
            }
            if (productStatus==1){
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
