﻿USE QuanLyNhanSu
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang NhanVien
IF (OBJECT_ID('SP_NhanVien') IS NOT NULL)
  DROP PROCEDURE SP_NhanVien
GO

CREATE PROCEDURE SP_NhanVien
(
	@MaNV varchar(10),
	@HoTen nvarchar(50),
	@GioiTinh bit,
	@NgaySinh date,
	@SoCM varchar(10),
	@DienThoai varchar(10),
	@Email varchar(50),
	@DiaChi nvarchar(max),
	@Hinh varchar(max),
	@TrinhDoHV nvarchar(30),
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM NhanVien
		END
	IF @StatementType = 'Insert'
		BEGIN
			INSERT INTO NhanVien VALUES(@MaNV, @HoTen, @GioiTinh, @NgaySinh, @SoCM, 
				@DienThoai, @MaNV + '@cty.com.vn', @DiaChi, @Hinh, @TrinhDoHV)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE NhanVien 
			SET HoTen = @HoTen, GioiTinh = @GioiTinh, NgaySinh = @NgaySinh, SoCM = @SoCM,
				DienThoai = @DienThoai, Email = @Email, DiaChi = @DiaChi, Hinh = @Hinh, TrinhDoHV = @TrinhDoHV
			WHERE MaNV = @MaNV
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM NhanVien WHERE MaNV = @MaNV
		END
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang PhongBan
IF (OBJECT_ID('SP_PhongBan') IS NOT NULL)
  DROP PROCEDURE SP_PhongBan
GO

CREATE PROCEDURE SP_PhongBan
(
	@MaPB varchar(5),
	@TenPB nvarchar(50),
	@MaTruongPhong varchar(10),
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM PhongBan
		END
	IF @StatementType = 'Insert'
		BEGIN
			INSERT INTO PhongBan VALUES(@MaPB, @TenPB, @MaTruongPhong)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE PhongBan 
			SET TenPB = @TenPB, MaTruongPhong = @MaTruongPhong
			WHERE MaPB = @MaPB
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM PhongBan WHERE MaPB = @MaPB
		END
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang ChucVu
IF (OBJECT_ID('SP_ChucVu') IS NOT NULL)
  DROP PROCEDURE SP_ChucVu
GO

CREATE PROCEDURE SP_ChucVu
(
	@MaCV varchar(5),
	@TenCV nvarchar(50),
	@PhuCap real,
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM ChucVu
		END
	IF @StatementType = 'Insert'
		BEGIN
			INSERT INTO ChucVu VALUES(@MaCV, @TenCV, @PhuCap)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE ChucVu 
			SET TenCV = @TenCV, PhuCap = @PhuCap
			WHERE MaCV = @MaCV
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM ChucVu WHERE MaCV = @MaCV
		END
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang HopDong
IF (OBJECT_ID('SP_HopDong') IS NOT NULL)
  DROP PROCEDURE SP_HopDong
GO

CREATE PROCEDURE SP_HopDong
(
	@MaHD varchar(10),
	@MaNV varchar(10),
	@MaCV varchar(5),
	@MaPB varchar(5),
	@NgayVaoLam date,
	@NgayKetThuc date,
	@HeSoLuong real,
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM HopDong
		END
	IF @StatementType = 'Insert'
		BEGIN
			INSERT INTO HopDong VALUES(@MaHD, @MaNV, @MaCV, @MaPB, (SELECT CAST(getdate() AS date)), @NgayKetThuc, @HeSoLuong)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE HopDong 
			SET MaNV = @MaNV, MaCV = @MaCV, MaPB = @MaPB, NgayVaoLam = @NgayVaoLam, NgayKetThuc = @NgayKetThuc, HeSoLuong = @HeSoLuong
			WHERE MaHD = @MaHD
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM HopDong WHERE MaHD = @MaHD
		END
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang TaiKhoan
IF (OBJECT_ID('SP_TaiKhoan') IS NOT NULL)
  DROP PROCEDURE SP_TaiKhoan
GO
CREATE PROCEDURE SP_TaiKhoan
(
	@MaNV varchar(10),
	@MatKhau varchar(50),
	@TrangThai bit,
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM TaiKhoan
		END
	IF @StatementType = 'Insert'
		BEGIN
			INSERT INTO TaiKhoan VALUES(@MaNV, @MatKhau, @TrangThai)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE TaiKhoan 
			SET MatKhau = @MatKhau, TrangThai = @TrangThai
			WHERE MaNV = @MaNV
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM TaiKhoan WHERE MaNV = @MaNV
		END
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang ThanNhan
IF (OBJECT_ID('SP_ThanNhan') IS NOT NULL)
  DROP PROCEDURE SP_ThanNhan
GO
CREATE PROCEDURE SP_ThanNhan
(
	@MaTN int,
	@HoTen nvarchar(50),
	@NgheNghiep nvarchar(50),
	@MoiQuanHe nvarchar(20),
	@MaNV varchar(10),
	@GiamTruPhuThuoc bit,
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM ThanNhan
		END
	IF @StatementType = 'Insert'
		BEGIN
			INSERT INTO ThanNhan VALUES(@HoTen, @NgheNghiep, @MoiQuanHe, @MaNV, @GiamTruPhuThuoc)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE ThanNhan 
			SET HoTen = @HoTen, NgheNghiep = @NgheNghiep, MoiQuanHe = @MoiQuanHe, MaNV = @MaNV, GiamTruPhuThuoc = @GiamTruPhuThuoc
			WHERE MaTN = @MaTN
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM ThanNhan WHERE MaTN = @MaTN
		END
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang ChamCong
IF (OBJECT_ID('SP_ChamCong') IS NOT NULL)
  DROP PROCEDURE SP_ChamCong
GO

CREATE PROCEDURE SP_ChamCong
(
	@MaNV varchar(10),
	@Ngay date,
	@TinhTrang bit,
	@TangCa int,
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM ChamCong
		END
	IF @StatementType = 'Insert'
		BEGIN
			IF @Ngay is null
				BEGIN
					SET @Ngay = (SELECT CAST(getdate() AS date))
				END
			INSERT INTO ChamCong VALUES(@MaNV, @Ngay, @TinhTrang, @TangCa)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE ChamCong 
			SET TinhTrang = @TinhTrang, TangCa = @TangCa
			WHERE MaNV = @MaNV AND Ngay = @Ngay
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM ChamCong WHERE MaNV = @MaNV AND Ngay = @Ngay
		END
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang GiaTriChung
IF (OBJECT_ID('SP_GiaTriChung') IS NOT NULL)
  DROP PROCEDURE SP_GiaTriChung
GO

CREATE PROCEDURE SP_GiaTriChung
(
	@TenGiaTri nvarchar(50),
	@GiaTri real,
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM GiaTriChung
		END
	IF @StatementType = 'Insert'
		BEGIN
			INSERT INTO GiaTriChung VALUES(@TenGiaTri, @GiaTri)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE GiaTriChung 
			SET GiaTri = @GiaTri
			WHERE TenGiaTri = @TenGiaTri
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM GiaTriChung WHERE TenGiaTri = @TenGiaTri
		END
GO

--Tao Stored Procedure Select all, Insert, Update, Delete cho bang ThueTNCN
IF (OBJECT_ID('SP_BacThueTNCN') IS NOT NULL)
  DROP PROCEDURE SP_BacThueTNCN
GO

CREATE PROCEDURE SP_BacThueTNCN
(
	@Luong int,
	@Thue real,
	@StatementType char(6)
)
AS
	IF @StatementType = 'Select'
		BEGIN
			SELECT * FROM BacThueTNCN
		END
	IF @StatementType = 'Insert'
		BEGIN
			INSERT INTO BacThueTNCN VALUES(@Luong, @Thue)
		END
	IF @StatementType = 'Update'
		BEGIN
			UPDATE BacThueTNCN 
			SET Thue = @Thue
			WHERE Luong = @Luong
		END
	IF @StatementType = 'Delete'
		BEGIN
			DELETE FROM BacThueTNCN WHERE Luong = @Luong
		END
GO

--Tao Function lay Gia tri tu bang GiaTriChung
IF (OBJECT_ID('FN_SelectGiaTri') IS NOT NULL)
  DROP FUNCTION FN_SelectGiaTri
GO
CREATE FUNCTION FN_SelectGiaTri
(
	@TenGiaTri nvarchar(50)
)
RETURNS real
AS
	BEGIN
		DECLARE @GiaTri real
		SET @GiaTri = (SELECT GiaTri FROM GiaTriChung WHERE TenGiaTri = @TenGiaTri)
		RETURN @GiaTri
	END
GO

--Tao Function tinh luong chinh
IF (OBJECT_ID('FN_LuongChinh') IS NOT NULL)
  DROP FUNCTION FN_LuongChinh
GO
CREATE FUNCTION FN_LuongChinh
(
	@MaNV varchar(10)
)
RETURNS int
AS
	BEGIN
		DECLARE @LuongChinh int
		SET @LuongChinh = (SELECT HeSoLuong FROM HopDong WHERE MaNV = 'IT001')*[dbo].[FN_SelectGiaTri]('LuongCB')
		RETURN @LuongChinh
	END
GO

--Tao Function tinh so ngay cong theo thang/nam
IF (OBJECT_ID('FN_SoNgayCong') IS NOT NULL)
  DROP FUNCTION FN_SoNgayCong
GO
CREATE FUNCTION FN_SoNgayCong
(
	@MaNV varchar(10),
	@NgayDauThang date
)
RETURNS int
AS
	BEGIN
		DECLARE @NgayCong int
		SET @NgayCong = (SELECT count(MaNV) FROM ChamCong WHERE MaNV = @MaNV AND 
				Ngay BETWEEN @NgayDauThang AND EOMONTH(@NgayDauThang))

		RETURN @NgayCong
	END
GO

--Tao Function tinh thue TNCN
IF (OBJECT_ID('FN_TinhThueTNCN') IS NOT NULL)
  DROP FUNCTION FN_TinhThueTNCN
GO
CREATE FUNCTION FN_TinhThueTNCN
(
	@ThuNhapChiuThue int
)
RETURNS int
AS
	BEGIN
		DECLARE @ThueTNCN int
		SET @ThueTNCN = @ThuNhapChiuThue*(SELECT TOP 1 Thue FROM BacThueTNCN WHERE Luong < 16000000 ORDER BY Luong DESC)
		IF @ThueTNCN < 0 SET @ThueTNCN = 0
		RETURN @ThueTNCN
	END
GO

--Tao Stored Procedure Insert cho bang BangLuong
IF (OBJECT_ID('SP_Insert_BangLuong') IS NOT NULL)
  DROP PROCEDURE SP_Insert_BangLuong
GO

CREATE PROCEDURE SP_Insert_BangLuong
(
	@MaNV varchar(10),
	@NgayNhanLuong date,
	@TamUng int,
	@TrangThai bit
)
AS
	DECLARE	@LuongChinh int,
			@NgayCong int,
			@PC_TrachNhiem int,
			@ThuNhap int,
			@BHXH int,
			@BHYT int,
			@BHTN int,
			@GiamTruPhuThuoc int,
			@ThueTNCN int,			
			@ThucLanh int		
	
	SET @LuongChinh = [dbo].[FN_LuongChinh](@MaNV)
	SET @NgayCong = [dbo].[FN_SoNgayCong]('IT001', (SELECT DATEADD(DAY, 1, EOMONTH(@NgayNhanLuong, -1))))
	SET @PC_TrachNhiem = @LuongChinh*(SELECT PhuCap FROM ChucVu WHERE MaCV = (Select MaCV FROM HopDong WHERE MaNV = @MaNV))
	SET @ThuNhap = @LuongChinh*@NgayCong/26 + @PC_TrachNhiem
	SET @BHXH = @LuongChinh*[dbo].[FN_SelectGiaTri]('BHXH')
	SET @BHYT = @LuongChinh*[dbo].[FN_SelectGiaTri]('BHYT')
	SET @BHTN = @LuongChinh*[dbo].[FN_SelectGiaTri]('BHTN')
	SET @GiamTruPhuThuoc = 3600000*(SELECT COUNT(MaTN) FROM ThanNhan WHERE MaNV = @MaNV AND GiamTruPhuThuoc = 1)
	SET @ThueTNCN = [dbo].[FN_TinhThueTNCN](@ThuNhap - @BHXH - @BHYT - @BHTN - @GiamTruPhuThuoc)
	SET @ThucLanh = @ThuNhap - @BHXH - @BHYT - @BHTN - @ThueTNCN

	INSERT INTO BangLuong VALUES(@MaNV, @NgayNhanLuong, @LuongChinh, @NgayCong, @PC_TrachNhiem,
					@ThuNhap, @BHXH, @BHYT, @BHTN, @GiamTruPhuThuoc, @ThueTNCN, @TamUng, @ThucLanh, @TrangThai)
GO

--Tao Function tinh so luong nam nu
IF (OBJECT_ID('FN_SLNamNu') IS NOT NULL)
  DROP FUNCTION FN_SLNamNu
GO
CREATE FUNCTION FN_SLNamNu
(
	--Truyen vao 0 hoặc 1 tuong ung voi Nu hoac Nam
	@GioiTinh int,
	--Tinh so luong theo Phong ban, neu bang null thi tinh het tat ca
	@MaPhongBan varchar(5)
)
RETURNS int
AS
	BEGIN
		DECLARE @SoLuong int
		SET @SoLuong = (SELECT COUNT(*) FROM NhanVien JOIN HopDong ON NhanVien.MaNV = HopDong.MaNV
							WHERE MaPB like '%' + @MaPhongBan + '%' AND GioiTinh = @GioiTinh)

		RETURN @SoLuong
	END
GO

--Tao Stored Procedure in ra so luong nam nu
IF (OBJECT_ID('SP_SLNamNu') IS NOT NULL)
  DROP PROCEDURE SP_SLNamNu
GO

CREATE PROCEDURE SP_SLNamNu
(
	--Tinh so luong theo Phong ban, neu bang null thi tinh het tat ca
	@MaPhongBan varchar(5)
)
AS
	SELECT [dbo].[FN_SLNamNu](0, @MaPhongBan), [dbo].[FN_SLNamNu](1, @MaPhongBan)

GO
	
--Tao Function tinh so luong nhan vien
IF (OBJECT_ID('FN_SLNhanVien') IS NOT NULL)
  DROP FUNCTION FN_SLNhanVien
GO
CREATE FUNCTION FN_SLNhanVien
(
	--Tinh so luong theo Phong ban, neu bang null thi tinh het tat ca
	@MaPhongBan varchar(5)
)
RETURNS int
AS
	BEGIN
		DECLARE @SoLuong int
		SET @SoLuong = (SELECT COUNT(*) FROM NhanVien JOIN HopDong ON NhanVien.MaNV = HopDong.MaNV WHERE MaPB like '%' + @MaPhongBan + '%')

		RETURN @SoLuong
	END
GO

--Tao Stored Procedure in ra so luong nam nu
IF (OBJECT_ID('SP_SLNhanVien') IS NOT NULL)
  DROP PROCEDURE SP_SLNhanVien
GO
CREATE PROCEDURE SP_SLNhanVien
AS
	SELECT [dbo].[FN_SLNhanVien](''), [dbo].[FN_SLNhanVien]('GD'), [dbo].[FN_SLNhanVien]('IT'), [dbo].[FN_SLNhanVien]('KT'), 
		[dbo].[FN_SLNhanVien]('MK'), [dbo].[FN_SLNhanVien]('NS'), [dbo].[FN_SLNhanVien]('SL')
GO		
exec SP_SLNhanVien

--Tao Stored Procedure in ra table NhanVien
IF (OBJECT_ID('SP_tblNhanVien') IS NOT NULL)
  DROP PROCEDURE SP_tblNhanVien
GO
CREATE PROCEDURE SP_tblNhanVien
AS
	SELECT NhanVien.MaNV, MaHD, HoTen, GioiTinh, NgaySinh, SoCM, DienThoai, Email, DiaChi, TrinhDoHV FROM NhanVien JOIN HopDong ON NhanVien.MaNV = HopDong.MaNV ORDER BY MaPB
GO		
exec SP_tblNhanVien

