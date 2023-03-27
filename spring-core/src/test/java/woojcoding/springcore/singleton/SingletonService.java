package woojcoding.springcore.singleton;

public class SingletonService {
    //1. static 영역에 객체 1개 생성
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어 객체 인스턴스가 필요하다면  static 메서드를 통해 조회하도록 허용해준다. -> 항상 같은 인스턴스를 반환한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언하여 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
