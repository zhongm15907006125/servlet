package cn.java.mydoc.dao;
import java.util.List;

import cn.java.mydoc.bean.*;
public interface ProflieDao {
    public List<Profile> getAll();
    public Profile getById(int id);
    public int updateProfile(Profile Profile);
}
