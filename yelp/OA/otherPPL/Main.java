public class Main {
    public static void main(String[] args) {
        BussinessResponseRate OApractice1 = new BussinessResponseRate();
        System.out.println(OApractice1.bussiness_resonsiveness_rate(42, OApractice1.messages));

        ReachableBusiness OA1 = new ReachableBusiness();
        OA1.output();

        ActiveBusiness OA2 = new ActiveBusiness();
        OA2.output();

        BusinessLocation OA3 = new BusinessLocation();
        OA3.output();
    }
}
