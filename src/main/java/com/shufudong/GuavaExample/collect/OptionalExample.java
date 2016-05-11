/**
 * Copyright 2016 www.xling123.com
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shufudong.GuavaExample.collect;

import com.google.common.base.Optional;

import java.util.Set;

/**
 * @author <a href="mailto:shufudong@gmail.com">舒阜东</a>
 * @ClassName OptionalExample
 * @category 对Optional类中函数的示例
 * @since 2016-05-12
 */
public class OptionalExample {

    public static void main(String[] args) {
        System.out.println(OptionalExample.fromNullable("带入一个字符串对象."));
        System.out.println(OptionalExample.fromNullable(null));
        try {
            OptionalExample.testOptional2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        OptionalExample.testMethodReturn();
    }

    /**
     * @param object
     * @return
     * @category fromNullable函数主要判断object参数是否为空。
     * 如果为空,可以在fromNullable函数后面增加处理
     * @throw
     */
    public static Object fromNullable(Object object) {
        return Optional.fromNullable(object).or("参数object为空,默认返回这个字符串提示.");
    }

    /**
     * @return
     * @category <p>常用静态方法：</p>
     * <ol>
     * <li>Optional.of(T)：获得一个Optional对象，其内部包含了一个非null的T数据类型实例，若T=null，则立刻报错。</li>
     * <li>Optional.absent()：获得一个Optional对象，其内部包含了空值</li>
     * <li>Optional.fromNullable(T)：将一个T的实例转换为Optional对象，T的实例可以不为空，也可以为空[Optional.fromNullable(null)，和Optional.absent()等价。</li>
     * </ol>
     * @throw
     */
    public static void testOptional2() throws Exception {
        Optional<Integer> possible = Optional.of(6);
        Optional<Integer> absentOpt = Optional.absent();
        Optional<Integer> NullableOpt = Optional.fromNullable(null);
        Optional<Integer> NoNullableOpt = Optional.fromNullable(10);
        if (possible.isPresent()) {
            System.out.println("possible isPresent:" + possible.isPresent());
            System.out.println("possible value:" + possible.get());
        }
        if (absentOpt.isPresent()) {
            System.out.println("absentOpt isPresent:" + absentOpt.isPresent());
        }
        if (NullableOpt.isPresent()) {
            System.out.println("fromNullableOpt isPresent:" + NullableOpt.isPresent());
        }
        if (NoNullableOpt.isPresent()) {
            System.out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent());
        }
    }

    /**
     * @return
     * @category <p>实例方法：</p>
     * <ol>
     * <li> boolean isPresent()：如果Optional包含的T实例不为null，则返回true；若T实例为null，返回false</li>
     * <li>T get()：返回Optional包含的T实例，该T实例必须不为空；否则，对包含null的Optional实例调用get()会抛出一个IllegalStateException异常</li>
     * <li>T or(T)：若Optional实例中包含了传入的T的相同实例，返回Optional包含的该T实例，否则返回输入的T实例作为默认值</li>
     * <li>T orNull()：返回Optional实例中包含的非空T实例，如果Optional中包含的是空值，返回null，逆操作是fromNullable()</li>
     * <li>Set<T> asSet()：返回一个不可修改的Set，该Set中包含Optional实例中包含的所有非空存在的T实例，且在该Set中，每个T实例都是单态，如果Optional中没有非空存在的T实例，返回的将是一个空的不可修改的Set。</li>
     * </ol>
     * @throw
     */
    public static void testMethodReturn() {
        Optional<Long> value = method();
        if (value.isPresent() == true) {
            System.out.println("获得返回值: " + value.get());
        } else {

            System.out.println("获得返回值: " + value.or(-12L));
        }

        System.out.println("获得返回值 orNull: " + value.orNull());

        Optional<Long> valueNoNull = methodNoNull();
        if (valueNoNull.isPresent() == true) {
            Set<Long> set = valueNoNull.asSet();
            System.out.println("获得返回值 set 的 size : " + set.size());
            System.out.println("获得返回值: " + valueNoNull.get());
        } else {
            System.out.println("获得返回值: " + valueNoNull.or(-12L));
        }

        System.out.println("获得返回值 orNull: " + valueNoNull.orNull());
    }

    private static Optional<Long> method() {
        return Optional.fromNullable(null);
    }

    private static Optional<Long> methodNoNull() {
        return Optional.fromNullable(15L);
    }
}
