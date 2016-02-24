package com.hubspot.httpql.filter;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Param;

import com.hubspot.httpql.ConditionProvider;
import com.hubspot.httpql.Filter;

public class NotEqual extends FilterBase implements Filter {

  @Override
  public String[] names() {
    return new String[] {
        "ne", "neq", "not"
    };
  }

  @Override
  public <T> ConditionProvider<T> getConditionProvider(final Field<T> field) {
    return new ConditionProvider<T>(field) {

      @Override
      public Condition getCondition(Param<T> value) {
        return field.isNull().or(field.notEqual(value));
      }

    };
  }

}
