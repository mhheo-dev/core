package hello.core.discount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다")
    void vip_discount_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discountPrice = discountPolicy.discount(member, 10000);

        //then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되면 안된다")
    void vip_discount_x(){
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        int discountPrice = discountPolicy.discount(member, 10000);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}