package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추상화 및 구체화에 둘다 의존 DIP 위배 
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
