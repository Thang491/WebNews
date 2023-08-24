package com.thangdotaplaptrinhweb.paging;

import com.thangdotaplaptrinhweb.sort.Sorter;

public interface Pageble {
 Integer getPage();
 Integer getOffset();
 Integer getLimit();
 Sorter getSorter();
}
