USE QuanLyNhanSu
GO

--Tao Stored Procedure tim kiem phong ban theo ma
IF (OBJECT_ID('SP_FindPhongBanByCode') IS NOT NULL)
  DROP PROCEDURE SP_FindPhongBanByCode
GO
CREATE PROCEDURE SP_FindPhongBanByCode
(
	@MaPB varchar(5)
)
AS
	IF @MaPB is not null
		BEGIN
			SELECT * FROM PhongBan WHERE MaPB = @MaPB
		END
	ELSE
		BEGIN
			SELECT * FROM PhongBan
		END
GO

EXEC SP_FindPhongBanByCode null

--Tao Stored Procedure tim kiem Chuc vu theo ma
IF (OBJECT_ID('SP_FindChucVuByCode') IS NOT NULL)
  DROP PROCEDURE SP_FindChucVuByCode
GO
CREATE PROCEDURE SP_FindChucVuByCode
(
	@MaCV varchar(5)
)
AS
	IF @MaCV is not null
		BEGIN
			SELECT * FROM ChucVu WHERE MaCV = @MaCV
		END
	ELSE
		BEGIN
			SELECT * FROM ChucVu
		END
GO

EXEC SP_FindChucVuByCode 'NT'

--Tao Stored Procedure tim kiem Tai khoan theo ten Tai khoan
IF (OBJECT_ID('SP_FindTaiKhoanByName') IS NOT NULL)
  DROP PROCEDURE SP_FindTaiKhoanByName
GO
CREATE PROCEDURE SP_FindTaiKhoanByName
(
	@TaiKhoan varchar(20)
)
AS
	BEGIN
		SELECT * FROM TaiKhoan WHERE TaiKhoan = @TaiKhoan
	END
GO

EXEC SP_FindTaiKhoanByName 'admin'