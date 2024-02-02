package com.g7.repository;

import com.g7.entity.SanPham;
import java.util.ArrayList;

public interface SP_SPCT_Repository {
    public ArrayList selectOffset(int indexOffset);
    public int create(Object o);
    public int update(Object o);
    public int remove(int id);
}
