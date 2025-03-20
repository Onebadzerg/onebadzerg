package com.example.lms_backend.service;

import com.example.lms_backend.model.Member;
import com.example.lms_backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Retrieve all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Retrieve member by ID
    public Optional<Member> getMemberById(int id) {
        return memberRepository.findById(id);
    }

    // Retrieve member by email
    public Optional<Member> getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    // Add new member
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    // Update existing member
    public Member updateMember(int id, Member memberDetails) {
        return memberRepository.findById(id).map(member -> {
            member.setName(memberDetails.getName());
            member.setPassword(memberDetails.getPassword());
            member.setEmail(memberDetails.getEmail());
            member.setPhoneNumber(memberDetails.getPhoneNumber());
            member.setIsAdmin(memberDetails.getIsAdmin());
            return memberRepository.save(member);
        }).orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    // Delete member by ID
    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }
}
