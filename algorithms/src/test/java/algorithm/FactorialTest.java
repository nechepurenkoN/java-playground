package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.nechepurenkon.javaplayground.parallel.Factorial;
import java.math.BigInteger;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    public void testFactorial() {
        final var sa = new SoftAssertions();
        sa.assertThat(BigInteger.ONE).isEqualByComparingTo(new Factorial(1).count());
        sa.assertThat(BigInteger.valueOf(120)).isEqualByComparingTo(new Factorial(5).count());
        sa.assertThat(BigInteger.valueOf(3628800)).isEqualByComparingTo(new Factorial(10).count());
        sa.assertThat(BigInteger.valueOf(39916800)).isEqualByComparingTo(new Factorial(11).count());
        sa.assertThat(BigInteger.valueOf(479001600)).isEqualByComparingTo(new Factorial(12).count());
        sa.assertThat(BigInteger.valueOf(6227020800L)).isEqualByComparingTo(new Factorial(13).count());
        sa.assertThat(new BigInteger("87178291200")).isEqualByComparingTo(new Factorial(14).count());
        sa.assertThat(new BigInteger("265252859812191058636308480000000")).isEqualByComparingTo(new Factorial(30).count());
        sa.assertThat(new BigInteger("265252859812191058636308480000000")).isEqualByComparingTo(new Factorial(30).count());
        sa.assertThat(new BigInteger("30414093201713378043612608166064768844377641568960512000000000000")).isEqualByComparingTo(new Factorial(50).count());
        sa.assertThat(new BigInteger("771053011335386004144639397775028360595556401816010239163410994033970851827093069367090769795539033092647861224230677444659785152639745401480184653174909762504470638274259120173309701702610875092918816846985842150593623718603861642063078834117234098513725265045402523056575658860621238870412640219629971024686826624713383660963127048195572279707711688352620259869140994901287895747290410722496106151954257267396322405556727354786893725785838732404646243357335918597747405776328924775897564519583591354080898117023132762250714057271344110948164029940588827847780442314473200479525138318208302427727803133219305210952507605948994314345449325259594876385922128494560437296428386002940601874072732488897504223793518377180605441783116649708269946061380230531018291930510748665577803014523251797790388615033756544830374909440162270182952303329091720438210637097105616258387051884030288933650309756289188364568672104084185529365727646234588306683493594765274559497543759651733699820639731702116912963247441294200297800087061725868223880865243583365623482704395893652711840735418799773763054887588219943984673401051362280384187818611005035187862707840912942753454646054674870155072495767509778534059298038364204076299048072934501046255175378323008217670731649519955699084482330798811049166276249251326544312580289357812924825898217462848297648349400838815410152872456707653654424335818651136964880049831580548028614922852377435001511377656015730959254647171290930517340367287657007606177675483830521499707873449016844402390203746633086969747680671468541687265823637922007413849118593487710272883164905548707198762911703545119701275432473548172544699118836274377270607420652133092686282081777383674487881628800801928103015832821021286322120460874941697199487758769730544922012389694504960000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"))
          .isEqualByComparingTo(new Factorial(800).count());
        sa.assertAll();
    }
}