package cn.java.mydoc.biz;

import java.util.List;
import cn.java.mydoc.bean.*;
public interface ProfileBiz {
    public List<Profile> getAllProfiles();
    public Profile getProfile(int id);
    public boolean UpdateProfile(Profile profile);
}