
package objects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class User {

    @SerializedName("contributors_enabled")
    private Boolean contributorsEnabled;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("default_profile")
    private Boolean defaultProfile;
    @SerializedName("default_profile_image")
    private Boolean defaultProfileImage;
    @Expose
    private String description;
    @Expose
    private Entities entities;
    @SerializedName("favourites_count")
    private Long favouritesCount;
    @SerializedName("follow_request_sent")
    private Boolean followRequestSent;
    @SerializedName("followers_count")
    private Long followersCount;
    @Expose
    private Boolean following;
    @SerializedName("friends_count")
    private Long friendsCount;
    @SerializedName("geo_enabled")
    private Boolean geoEnabled;
    @SerializedName("has_extended_profile")
    private Boolean hasExtendedProfile;
    @Expose
    private Long id;
    @SerializedName("id_str")
    private String idStr;
    @SerializedName("is_translation_enabled")
    private Boolean isTranslationEnabled;
    @SerializedName("is_translator")
    private Boolean isTranslator;
    @Expose
    private Object lang;
    @SerializedName("listed_count")
    private Long listedCount;
    @Expose
    private String location;
    @Expose
    private String name;
    @Expose
    private Boolean notifications;
    @SerializedName("profile_background_color")
    private String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    private Object profileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    private Object profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    private Boolean profileBackgroundTile;
    @SerializedName("profile_banner_url")
    private String profileBannerUrl;
    @SerializedName("profile_image_url")
    private String profileImageUrl;
    @SerializedName("profile_image_url_https")
    private String profileImageUrlHttps;
    @SerializedName("profile_link_color")
    private String profileLinkColor;
    @SerializedName("profile_sidebar_border_color")
    private String profileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    private String profileSidebarFillColor;
    @SerializedName("profile_text_color")
    private String profileTextColor;
    @SerializedName("profile_use_background_image")
    private Boolean profileUseBackgroundImage;
    @Expose
    @SerializedName("protected")
    private Boolean _protected;
    @SerializedName("screen_name")
    private String screenName;
    @SerializedName("statuses_count")
    private Long statusesCount;
    @SerializedName("time_zone")
    private Object timeZone;
    @SerializedName("translator_type")
    private String translatorType;
    @Expose
    private Object url;
    @SerializedName("utc_offset")
    private Object utcOffset;
    @Expose
    private Boolean verified;

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public Long getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Long favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public Boolean getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public Long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Long followersCount) {
        this.followersCount = followersCount;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }

    public Long getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Long friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public Boolean getHasExtendedProfile() {
        return hasExtendedProfile;
    }

    public void setHasExtendedProfile(Boolean hasExtendedProfile) {
        this.hasExtendedProfile = hasExtendedProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Boolean getIsTranslationEnabled() {
        return isTranslationEnabled;
    }

    public void setIsTranslationEnabled(Boolean isTranslationEnabled) {
        this.isTranslationEnabled = isTranslationEnabled;
    }

    public Boolean getIsTranslator() {
        return isTranslator;
    }

    public void setIsTranslator(Boolean isTranslator) {
        this.isTranslator = isTranslator;
    }

    public Object getLang() {
        return lang;
    }

    public void setLang(Object lang) {
        this.lang = lang;
    }

    public Long getListedCount() {
        return listedCount;
    }

    public void setListedCount(Long listedCount) {
        this.listedCount = listedCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNotifications() {
        return notifications;
    }

    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public Object getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(Object profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public Object getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(Object profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public void setProfileBannerUrl(String profileBannerUrl) {
        this.profileBannerUrl = profileBannerUrl;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(Long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public Object getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Object timeZone) {
        this.timeZone = timeZone;
    }

    public String getTranslatorType() {
        return translatorType;
    }

    public void setTranslatorType(String translatorType) {
        this.translatorType = translatorType;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Object getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Object utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

}
