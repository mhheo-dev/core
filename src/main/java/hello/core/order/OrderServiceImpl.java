package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    /* 직접 주입방식 테스트가 어려움 , 권장 x */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
    //    @Autowired
    //    public void setMemberRepository(MemberRepository memberRepository) {
    //        System.out.println("memberRepository = " + memberRepository);
    //        this.memberRepository = memberRepository;
    //    }
    //
    //    @Autowired
    //    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    //        System.out.println("discountPolicy = " + discountPolicy);
    //        this.discountPolicy = discountPolicy;
    //    }

    //순서
    // 1.OrderServiceImpl 생성자
    // 2.setter를 이용한 것 setMember(setter 사용시 아래 생성자 필요 x, 의존성 다주입해줌)

    /*생성자가 한개일 경우 Autowired 생략가능*/
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("orderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
