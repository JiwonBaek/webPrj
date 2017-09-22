package ex1.di;

import java.util.Scanner;

public class Exam {// 데이터 서비스 담당

   private int kor;
   private int eng;
   private int math;
   
   

   public Exam() { // 생성자 : 한 번만 사용하는 초기화 함수
      this(1, 1, 1);
   }

   public Exam(int kor, int eng, int math) {

      this.kor = kor;
      this.eng = eng;
      this.math = math;
   }

   public double avg() {
      
      return (total() / 3);
   }

   public int total() {

      return kor + eng + math;
   }

   public int getKor() {
      return kor;
   }

   public void setKor(int kor) {
      this.kor = kor;
   }

   public int getEng() {
      return eng;
   }

   public void setEng(int eng) {
      this.eng = eng;
   }

   public int getMath() {
      return math;
   }

   public void setMath(int math) {
      this.math = math;
   }

   


}
