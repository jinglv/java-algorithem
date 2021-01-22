package demo.model;

/**
 * 对象排序，必须要重写父类的equals方法
 * 需要实现Comparable接口，重写compareTo方法
 *
 * @author jingLv
 * @date 2020/11/10
 */
public class Student implements Comparable<Student> {
    private final String name;
    private final int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * 自定义比较方法，重写Object父类equals方法
     * 学生类的对象比较，转换为字符串的比较
     *
     * @param student 学生对象
     * @return boolean
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
        return this.name.equals(another.name);
    }

    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return "demo.model.Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
