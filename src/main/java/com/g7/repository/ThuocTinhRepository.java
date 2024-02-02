package com.g7.repository;

import java.util.ArrayList;

public interface ThuocTinhRepository {

    public ArrayList selectOffset(int indexOffset, int indexThuocTinh);

    public int create(Object o,int indexThuocTinh);

    public int update(Object o,int indexThuocTinh);

    public int remove(int id,int indexThuocTinh);
}
