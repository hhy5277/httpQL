package com.hubspot.httpql.filter;

import java.util.Objects;

import com.hubspot.httpql.Filter;
import com.hubspot.httpql.internal.JoinFilter;

public abstract class FilterBase implements Filter {

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Filter)) {
      return false;
    }

    Class<?> filterClass = obj.getClass();

    if (obj instanceof JoinFilter) {
      filterClass = ((JoinFilter) obj).getFilter().getClass();
    }

    return getClass().equals(filterClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getClass());
  }

}
