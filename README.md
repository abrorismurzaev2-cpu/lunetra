# Lunetra

**Lunetra** — современный приватный трекер личных финансов.  
Красивый интерфейс в духе iOS / Telegram Mini Apps. Все данные хранятся только локально.

🌐 **Приложение:** https://abrorismurzaev2-cpu.github.io/lunetra/  
🏠 **Лендинг:** https://abrorismurzaev2-cpu.github.io/lunetra-landing/  
📢 **Telegram:** https://t.me/lunetra0  
📦 **Репозиторий:** https://github.com/abrorismurzaev2-cpu/lunetra  
🔒 **Политика:** [privacy.html](privacy.html)

---

## Важно: обновить index.html до v1.2

В папке проекта (`artifacts/lunetra/index.html`) лежит полная версия **v1.2** с:
- пустым стартом (без демо-данных)
- попапом подписки на @lunetra0 (один раз)
- новыми анимациями и ~34 доп. функциями

**Загрузите этот файл в репозиторий вручную:**
1. Откройте https://github.com/abrorismurzaev2-cpu/lunetra
2. `index.html` → Edit или **Add file → Upload files**
3. Замените содержимым из `artifacts/lunetra/index.html`
4. Commit

После этого обновите GitHub Pages и пересоберите APK.

---

## Как сделать APK (PWABuilder → RuStore)

1. **GitHub Pages:** Settings → Pages → branch `main` → root → Save  
2. **PWABuilder:** https://www.pwabuilder.com/ → URL приложения → Android → Generate  
3. **RuStore:** загрузите APK, укажите политику `.../privacy.html`, категория «Финансы»

Package ID пример: `app.lunetra.finance`

---

## Возможности v1.2
- Пустой старт, попап подписки (один раз)
- Доходы / расходы, заметки, дата, быстрые суммы
- 13 категорий, фильтры, поиск, свайп-удаление, Undo
- Бюджет, цели, streak, аналитика, 50/30/20
- Тёмная тема, скрытие баланса, компактный список
- Экспорт JSON/CSV, импорт, 6 валют
- Confetti, анимации, haptic, PWA

---

## Лендинг
Отдельный репозиторий: [lunetra-landing](https://github.com/abrorismurzaev2-cpu/lunetra-landing)  
Включите Pages там же → будет маркетинговая страница.
