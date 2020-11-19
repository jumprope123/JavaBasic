package lab;

public class Q07 {

/*

7. 각 표현식에 대한 결과 값을 계산하여라. 만일 틀린 식이 있다면 수정하여라.

    가.  3 + 4.5 * 2 + 27 / 8
    -> 15.0
    나.  true || false && 3 < 4 || !(5 == 7)
    -> true
    다.  true || (3 < 5 && 6 >= 2)
    -> true
    라.  !true > 'A'
    -> boolean과 char는 비교가 불가능.
    마.  7 % 4 + 3 - 2 / 6 * 'Z'
    -> 6
    바.  'D' + 1 + 'M' % 2 / 3
    ->69
    사.  5.0 / 3 + 3 / 3
    -> 2.666666666666667
    아.  53 % 21 < 45 / 18
    -> false
    자.  (4 < 6) || true && false || false && (2 > 3)
    -> true
    차.  7 - (3 + 8 * 6 + 3) - (2 + 5 * 2)
    -> -59
    */

    public static void main(String[] args) {
        System.out.println(7 - (3 + 8 * 6 + 3) - (2 + 5 * 2));
    }
}
