package demo.linear;

/**
 * @author jingLv
 * @date 2021/01/18
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    /**
     * 覆盖Object equals方法，完成类对象的值比较
     *
     * @return
     */
    @Override
    public boolean equals(Object student) {
        // 判断当期对象是否是student对象，如果是的话则不需要进行转换
        if (this == student) {
            return true;
        }
        // 判断student是否是空对象，如果是空则返回false
        if (student == null) {
            return false;
        }
        // 判断当前的类对象是否与student的类对象相等，如果不等则返回false
        if (this.getClass() != student.getClass()) {
            return false;
        }
        Student another = (Student) student;
        // 比较的值，不区分大小写
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }
}
