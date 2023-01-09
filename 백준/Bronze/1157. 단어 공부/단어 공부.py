str = input().upper()

res = dict()

for i in str:
    if i not in res:
        res[i] = 0
    res[i] += 1

m_value = max(res.values())

m_key = [k for k, v in res.items() if v == m_value ]

if len(m_key) > 1:
    print('?')
else:
    print(*m_key)