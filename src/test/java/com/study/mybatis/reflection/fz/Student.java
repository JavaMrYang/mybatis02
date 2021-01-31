package com.study.mybatis.reflection.fz;

/**
 * @author :LiuYang
 * @desc
 * @date :2021/1/31/031 17:40
 **/
public class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder{
        private String id;
        private String name;

        public Builder(String id) {
            this.id = id;
        }

        public Builder buildId(String id) {
            this.id = id;
            return this;
        }


        public Builder buildName(String name) {
            this.name = name;
            return this;
        }

        public Student build(){
            return new Student(this.id,this.name);
        }
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
