SELECT a.APNT_NO APNTNO, p.PT_NAME PTNAME, p.PT_NO PTNO, a.MCDP_CD MCDPCD, d.DR_NAME DRNAME, a.APNT_YMD APNTYMD
FROM APPOINTMENT a
JOIN PATIENT p ON p.PT_NO = a.PT_NO
JOIN DOCTOR d ON d.DR_ID = a.MDDR_ID
AND DATE_FORMAT(a.APNT_YMD, '%Y-%m-%d') = '2022-04-13'
AND a.APNT_CNCL_YN = 'N'
AND a.MCDP_CD = 'CS'
ORDER BY a.APNT_YMD ASC;