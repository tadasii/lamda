package com.zz;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javafx.scene.input.KeyCode.R;

/**
 * Created by zhangzheng on 2019/6/24.
 */
public class Test {
    public static void main(String[] args) throws  Exception {

        test7();
    }

    public static void test(){
        List<String> strings = Arrays.asList("abc","","bc","efg","abc");
        List<String> filtered =  strings.stream().filter(str->!str.isEmpty()).collect(Collectors.toList());
        filtered.forEach(str-> System.out.println(str));
        System.out.println("================");
        filtered.forEach(System.out::println);

        Random random = new Random();
    }

    public static void test2(){
        List<Widget> widgets = new ArrayList<>();
        Widget widget1 = new Widget("red",1);
        Widget widget2 = new Widget("red2",2);
        Widget widget3 = new Widget("red3",3);
        Widget widget4 = new Widget("red",4);
        Widget widget5 = new Widget("red",5);
        Widget widget6 = new Widget("red",6);
        widgets.add(widget1);
        widgets.add(widget2);
        widgets.add(widget3);
        widgets.add(widget4);
        widgets.add(widget5);
        widgets.add(widget6);
        int sum = widgets.stream().filter(w->
        w.getColor().equals("red")).mapToInt(Widget::getWeight).sum();
        System.out.println(sum);
        int min =  widgets.stream().filter(w->
                w.getColor().equals("red")).mapToInt(w->w.getWeight()).min().getAsInt();
        System.out.println(min);

    }

    public static void test3(){
        List<String> worrdList = Arrays.asList("a","aafaafasfqrqwgsd","sfaioreo张");
        List<String> upWordList = worrdList.stream().map(String::toUpperCase).collect(Collectors.toList());
        upWordList.forEach(System.out::println);
    }

    public static void test4(){
        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5,6));
        List<Integer> list =inputStream.flatMap(childList->childList.stream()).collect(Collectors.toList());
        System.out.println(list);
        Integer[] integers=list.stream().filter(n->n%2==0).toArray(Integer[]::new);
        Arrays.stream(integers).forEach(System.out::println);
    }

    public static void test5(){
        Stream.of("one", "two", "three", "four")
                .filter(e->e.length()>3)
                .peek(e-> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e)).count();
    }

    public static void print(String text){
        Optional.ofNullable(text).ifPresent(System.out::println);
    }

    public static int getLength(String text){
      return   Optional.ofNullable(text).map(s->s.length()).orElse(-1);
    }

    public static int reduceTest(){
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce( Double::min).get();
        System.out.println(minValue);
        Stream<Integer> integers = Stream.of(1,2,3,4);
       Optional<Integer> optional=  integers.reduce(Integer::sum);
       return optional.get();
    }

    public static void test6(){
        Stream<Integer> integers = Stream.of(1,2,3,4);
        integers.skip(3).forEach(System.out::println);
    }
   //找出最长一行的长度
    public static void test7() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("F:\\cloud\\cloudback\\Cloud-back\\ibocc-service\\logs\\cloud.log"));
        int longest = br.lines().
                mapToInt(String::length).
                max().
                getAsInt();
        br.close();
        System.out.println(longest);

    }
}
