import os
import subprocess

def build_minecraft_mod():
    print("========================================")
    print("   Bedro's Mod Builder for Python      ")
    print("========================================")

    # مسار مجلد المشروع (تأكد إنه مطابق لمكان مشروعك على الذاكرة)
    # ملاحظة: في بايثون على الأندرويد، المسار غالباً يبدأ بـ /storage/emulated/0/...
    project_dir = "/storage/emulated/0/noanimations-template-1.21.11"

    if not os.path.exists(project_dir):
        print(f"[-] الخطأ: مجلد المشروع غير موجود في المسار: {project_dir}")
        print("تأكد من تعديل متغير project_dir داخل الكود ليوجه لمجلد مشروعك بدقة.")
        return

    os.chdir(project_dir)
    print([+] تم الانتقال إلى مجلد المشروع: {project_dir})

    # إعطاء صلاحية التشغيل لملف gradlew (يعادل chmod +x)
    print("[*] جارٍ إعطاء صلاحيات التشغيل لـ Gradle...")
    os.system("chmod +x gradlew")

    # تنفيذ أمر التجميع
    print("[*] جارٍ تجميع المود واستخراج ملف الـ .jar (قد يستغرق وقتاً حسب قوة الهاتف)...")
    result = subprocess.run(["./gradlew", "build"], capture_output=False)

    if result.returncode == 0:
        print("\n[+] مبروك! تم بناء المود بنجاح (BUILD SUCCESSFUL)!")
        print("[+] ستجد ملف الـ .jar جاهزاً في المسار التالي:")
        print(f"    {project_dir}/build/libs/")
    else:
        print("\n[-] حدث خطأ أثناء التجميع. تأكد من توفر اتصال الإنترنت وثبيت Java بشكل صحيح.")

if __name__ == "__main__":
    build_minecraft_mod()
