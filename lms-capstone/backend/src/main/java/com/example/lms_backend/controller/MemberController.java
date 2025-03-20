package com.example.lms_backend.controller;

import com.example.lms_backend.model.Member;
import com.example.lms_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Retrieve all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Retrieve member by ID
    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable int id) {
        return memberService.getMemberById(id);
    }

    // Retrieve member by email
    @GetMapping("/email/{email}")
    public Optional<Member> getMemberByEmail(@PathVariable String email) {
        return memberService.getMemberByEmail(email);
    }

    // Add new member
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    // Update member
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable int id, @RequestBody Member memberDetails) {
        return memberService.updateMember(id, memberDetails);
    }

    // Delete member
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable int id) {
        memberService.deleteMember(id);
        return "Member with ID " + id + " has been deleted!";
    }
}
