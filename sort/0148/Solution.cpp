class Solution {
    public:
    ListNode* sortList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* p= head->next;
        ListNode* mid = head;
        ListNode* pre = nullptr;
        while (p != nullptr && p->next != nullptr) {
            p = p->next->next;
            mid = mid->next;
        }
        ListNode* tmp = mid;
        mid = mid->next;
        tmp->next = nullptr;
        ListNode* l = sortList(head);
        ListNode* r = sortList(mid);
        ListNode* h = new ListNode(0);
        ListNode* res = h;
        while (l != nullptr && r != nullptr) {
            if (l->val <= r->val) {
                h->next = l;
                l = l->next;
            } else {
                h->next = r;
                r = r->next;
            }
            h = h->next;
        }
        h->next = l != nullptr ? l : r;
        return res->next;
    }
};