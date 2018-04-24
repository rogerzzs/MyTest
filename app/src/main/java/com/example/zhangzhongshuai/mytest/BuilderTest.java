package com.example.zhangzhongshuai.mytest;

/**
 * Created by zhangzhongshuai on 2018/4/18.
 */

public class BuilderTest {
    public String name;
    public String age;
    public String sex;

    public static class BuilderTestBuild {
        private String name;
        private String age;
        private String sex;

        public BuilderTestBuild() {

        }

        public BuilderTestBuild setName(String name) {
            this.name = name;
            return this;
        }

        public BuilderTestBuild setAge(String age) {
            this.age = age;
            return this;
        }

        public BuilderTestBuild setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public BuilderTest build() {
            return new BuilderTest(this);
        }
    }

    public BuilderTest() {

    }

    public BuilderTest(BuilderTestBuild testBuild) {
        this.name = testBuild.name;
        this.age = testBuild.age;
        this.sex = testBuild.sex;
    }
}
