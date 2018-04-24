package com.example.zhangzhongshuai.pattern;

import android.util.Log;

/**
 * Created by zhangzhongshuai on 2018/4/18.
 */

public class BuilderTest {
    public String name;
    public String age;
    public String sex;

    public class BuilderTestBuild {
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
        Outer.Iner iner = new Outer().getIner();
        Seqence seqence = new Seqence(10);
        for (int i = 0; i < 10; i++) {
            seqence.add(i);
        }
        Selector selector = seqence.getSelectorImpl();
        while (!selector.end()) {
            Log.w("zzs", "很舒服的放得开：" + selector.current());
            selector.next();
        }


    }

    public BuilderTest(BuilderTestBuild testBuild) {
        this.name = testBuild.name;
        this.age = testBuild.age;
        this.sex = testBuild.sex;
    }
}
