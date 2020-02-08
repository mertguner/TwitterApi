
package objects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SearchMetadata {

    @SerializedName("completed_in")
    private Double completedIn;
    @Expose
    private Long count;
    @SerializedName("max_id")
    private Long maxId;
    @SerializedName("max_id_str")
    private String maxIdStr;
    @SerializedName("next_results")
    private String nextResults;
    @Expose
    private String query;
    @SerializedName("refresh_url")
    private String refreshUrl;
    @SerializedName("since_id")
    private Long sinceId;
    @SerializedName("since_id_str")
    private String sinceIdStr;

    public Double getCompletedIn() {
        return completedIn;
    }

    public void setCompletedIn(Double completedIn) {
        this.completedIn = completedIn;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public String getMaxIdStr() {
        return maxIdStr;
    }

    public void setMaxIdStr(String maxIdStr) {
        this.maxIdStr = maxIdStr;
    }

    public String getNextResults() {
        return nextResults;
    }

    public void setNextResults(String nextResults) {
        this.nextResults = nextResults;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRefreshUrl() {
        return refreshUrl;
    }

    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }

    public Long getSinceId() {
        return sinceId;
    }

    public void setSinceId(Long sinceId) {
        this.sinceId = sinceId;
    }

    public String getSinceIdStr() {
        return sinceIdStr;
    }

    public void setSinceIdStr(String sinceIdStr) {
        this.sinceIdStr = sinceIdStr;
    }

}
