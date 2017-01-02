package domains;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by rocks on 11/12/2016.
 */
public class Group {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal_marks() {
        return total_marks;
    }

    public void setTotal_marks(Integer total_marks) {
        this.total_marks = total_marks;
    }

    Integer total_marks=0;
}
