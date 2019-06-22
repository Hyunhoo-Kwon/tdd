import service.SubDate;

public class SubDateApplication {

    public static void main(String[] args) {
        try {
            SubDate subDate = new SubDate();
            System.out.println(subDate.sub("20191231", "20191201"));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
