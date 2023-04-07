public class ThirdProgram {
    public static void main(String[] args) {

        int numbers[] = new int[]{4,5,7,11,9,13,8,12};
        int sum = 20;
        int first[] = new int[numbers.length];
        int second[] = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(numbers[i] + numbers[j]  == sum){
                    first[numbers[i]]++;
                    second[numbers[j]]++;
                    break;
                }
            }
        }

    }
}
